package com.radoman.masinac.activity;
/**
    This file is part of Mašinac.

    Mašinac is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
**/

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.radoman.masinac.R;
import com.radoman.masinac.adapter.PostAdapter;
import com.radoman.masinac.model.Post;
import com.radoman.masinac.model.RecyclerItemClickListener;
import com.radoman.masinac.network.ServiceHandler;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PostFragment extends Fragment {
    RecyclerView recList;

    private static final String TAG_TEME = "teme";
    private static final String TAG_NASLOV = "naslov";
    private static final String TAG_CONTENT = "content";
    private static final String TAG_ATTACHMENTS = "attachments";
    private static final String TAG_ATTACHMENT_NAZIV = "naziv";
    private static final String TAG_ATTACHMENT_LINK = "link";


    private ProgressDialog pDialog;
    private static String url = "http://ferometal.rs/parserPost.php/";

    JSONArray contacts = null;
    ArrayList<HashMap<String, String>> temeList;
    ArrayList<HashMap<String[],String[]>> attachLinkList;
    ArrayList<HashMap<String[],String[]>> attachNazivList;
    private static int thread_id;
    private static int forum_id;
    Post post;

    public PostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_predmeti_oas, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            thread_id = Integer.parseInt(bundle.getString("thread_id"));
            forum_id = Integer.parseInt(bundle.getString("forum_id"));
        }
        temeList = new ArrayList<HashMap<String, String>>();
        attachLinkList = new ArrayList<HashMap<String[],String[]>>();
        attachNazivList = new ArrayList<HashMap<String[],String[]>>();
        recList = (RecyclerView) rootView.findViewById(R.id.forumPredmetiOAS);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        MainActivity.mToolbar.getMenu().clear();
        new GetTeme().execute();

        return rootView;
    }

    private class GetTeme extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("t", String.valueOf(thread_id)));
            nameValuePairs.add(new BasicNameValuePair("f", String.valueOf(forum_id)));
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET,nameValuePairs);




            Gson gson =  new Gson();
            post = gson.fromJson(jsonStr,Post.class);
            System.out.println(post.getTemes().get(0).getNaslov());

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */


            PostAdapter adapter = new PostAdapter(post.getTemes(),getActivity());
            recList.setAdapter(adapter);

            recList.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {


                }
            }));


        }
    }





}
