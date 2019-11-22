package edu.tarleton.edu.rho.climatemeetingplatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Johnny
 */
@Converter
public class StringToIntegerListConverter implements AttributeConverter<List<Integer>, String> 
{
    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        if(attribute == null) {
            return "";
        }
        String listString = attribute.toString();
        listString = listString.substring(1, listString.length()-1);
        return listString;
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        if(dbData == null || dbData.isBlank() || dbData.isEmpty()) {
            return null;
        }
        List<String> items_s = Arrays.asList(dbData.split("\\s*,\\s*"));
        List<Integer> items_i = items_s.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return items_i;
    }
    
    
    
}
