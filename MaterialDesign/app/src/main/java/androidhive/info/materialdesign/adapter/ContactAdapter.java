package androidhive.info.masinac.adapter;

/**
 * Created by SPACEMAN on 5/6/2015.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import androidhive.info.masinac.R;
import androidhive.info.masinac.model.Predmeti;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    ArrayList<HashMap<String, String>> temeList;

    public ContactAdapter(ArrayList<HashMap<String, String>> temeList) {
        this.temeList = temeList;
    }


    @Override
    public int getItemCount() {
        return temeList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {


            String post_link = temeList.get(i).get("poslednji_post_link");
            if(post_link.length()>0) {
                post_link = post_link.substring(0, 21);
                post_link = post_link.replaceAll("[\\D]", "");
                Log.d("ID: ", "" + Integer.parseInt(post_link));
                Predmeti p = new Predmeti();
                contactViewHolder.vTema.setText("Predmet: " + p.getPredmetOasById(Integer.parseInt(post_link)));
            }

            contactViewHolder.vTitle.setText(temeList.get(i).get("naslov"));
            contactViewHolder.vName.setText("Poslednje obaveštenje: " + temeList.get(i).get("poslednji_post"));
            contactViewHolder.vSurname.setText("Autor: " + temeList.get(i).get("autor"));


    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vSurname;
        protected TextView vEmail;
        protected TextView vTitle;
        protected TextView vTema;

        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtNaslov);
            vSurname = (TextView)  v.findViewById(R.id.txtPoslednjiPost);
            vEmail = (TextView)  v.findViewById(R.id.txtAutor);
            vTitle = (TextView) v.findViewById(R.id.title);
            vTema = (TextView) v.findViewById(R.id.txtTema);
        }
    }
}