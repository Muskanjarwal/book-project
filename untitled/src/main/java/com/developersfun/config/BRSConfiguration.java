package com.developersfun.config;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.core.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.xml.crypto.Data;
import java.util.Objects;

public class BRSConfiguration extends Configuration {
    private DataSourceFactory dataSourceFactory;

//    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory(){
        if(Objects.isNull(dataSourceFactory))
            dataSourceFactory=new DataSourceFactory();
        return dataSourceFactory;
    }

    public void setDataSourceFactory(DataSourceFactory dataSourceFactory){
        this.dataSourceFactory=dataSourceFactory;
    }


}
