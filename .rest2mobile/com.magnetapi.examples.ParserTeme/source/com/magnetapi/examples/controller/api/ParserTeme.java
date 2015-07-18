/**
 * File generated by Magnet rest2mobile 1.1 - Jun 17, 2015 8:22:52 PM
 * @see {@link http://developer.magnet.com}
 */

package com.magnetapi.examples.controller.api;

import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.async.StateChangedListener;

import com.magnetapi.examples.model.beans.*;

public interface ParserTeme {

  /**
   * Generated from URL GET http://ferometal.rs/parserPost.php?id=29&t=131
   * GET parserPost.php
   * @param id  style:QUERY
   * @param t  style:QUERY
   * @param listener
   * @return ParserTemeResult
   */
  Call<ParserTemeResult> parserTeme(
     String id,
     String t,
     StateChangedListener listener
  );


}
