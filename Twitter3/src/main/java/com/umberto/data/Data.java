package com.umberto.data;

import java.util.ArrayList;

public class Data {
    ArrayList< Object > statuses = new ArrayList < Object > ();
    Search_metadata Search_metadataObject;


    // Getter Methods

    public Search_metadata getSearch_metadata() {
        return Search_metadataObject;
    }

    // Setter Methods

    public void setSearch_metadata(Search_metadata search_metadataObject) {
        this.Search_metadataObject = search_metadataObject;
    }
}
