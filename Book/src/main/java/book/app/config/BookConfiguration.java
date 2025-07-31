package book.app.config;

import io.dropwizard.core.Configuration;
import io.dropwizard.db.DataSourceFactory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class BookConfiguration extends Configuration {

    @Valid
    @NotNull
//    This variable will store your database settings (like username, password, URL).
    private DataSourceFactory dataSourceFactory;

    public DataSourceFactory getDataSourceFactory(){
        if (Objects.isNull(dataSourceFactory)) {
            dataSourceFactory = new DataSourceFactory();
        }
        return dataSourceFactory;
    }

    public void setDataSourceFactory(DataSourceFactory dataSourceFactory){
        this.dataSourceFactory = dataSourceFactory;
    }
}
