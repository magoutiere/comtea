package fr.comtea.config;

import java.lang.reflect.Type;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import io.cucumber.java.ParameterType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SuppressWarnings("unused")
public class CucumberParameterType {

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public static Object transformer(final Object fromValue, final Type toValueType) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }

    @ParameterType(".*")
    public LocalDate localDate(final String chaineDate) {
        return LocalDate.parse(chaineDate);
    }
}
