/**
 * File generated by Magnet rest2mobile 1.1 - Jun 17, 2015 8:22:02 PM
 * @see {@link http://developer.magnet.com}
 */

package com.magnetapi.examples.model.beans;

import java.util.List;

/**
 * Generated from json example
{
  "destination_addresses" : [ "Embarcadero,298MarketStreet,SanFrancisco,CA94111,USA" ],
  "origin_addresses" : [ "435TassoStreet,PaloAlto,CA94301,USA" ],
  "rows" : [ {
    "elements" : [ {
      "distance" : {
        "text" : "33.1mi",
        "value" : "53242"
      },
      "duration" : {
        "text" : "42mins",
        "value" : "2512"
      },
      "status" : "OK"
    } ]
  } ],
  "status" : "OK"
}

 */

public class GoogleDistanceResult {

  
  private List<java.lang.String> destination_addresses;

  
  private List<java.lang.String> origin_addresses;

  
  private List<Row> rows;

  
  private String status;

  public List<java.lang.String> getDestination_addresses() {
    return destination_addresses;
  }
  public List<java.lang.String> getOrigin_addresses() {
    return origin_addresses;
  }
  public List<Row> getRows() {
    return rows;
  }
  public String getStatus() {
    return status;
  }

  /**
  * Builder for GoogleDistanceResult
  **/
  public static class GoogleDistanceResultBuilder {
    private GoogleDistanceResult toBuild = new GoogleDistanceResult();

    public GoogleDistanceResultBuilder() {
    }

    public GoogleDistanceResult build() {
      return toBuild;
    }

    public GoogleDistanceResultBuilder destination_addresses(List<java.lang.String> value) {
      toBuild.destination_addresses = value;
      return this;
    }
    public GoogleDistanceResultBuilder origin_addresses(List<java.lang.String> value) {
      toBuild.origin_addresses = value;
      return this;
    }
    public GoogleDistanceResultBuilder rows(List<Row> value) {
      toBuild.rows = value;
      return this;
    }
    public GoogleDistanceResultBuilder status(String value) {
      toBuild.status = value;
      return this;
    }
  }
}
