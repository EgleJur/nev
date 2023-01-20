package techin.tecn.egz.egzjur.configuration;

//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import java.time.format.DateTimeFormatter;
//import org.springframework.context.annotation.Primary;

@Configuration
public class ObjectMapping {

    private static final String dateFormat = "yyyy-MM-dd";
    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";


    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat(dateTimeFormat);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
        };
    }

//    @Bean
//    @Primary
//    public ObjectMapper objectMapper() {
//        JavaTimeModule module = new JavaTimeModule();
//        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
//        return new ObjectMapper()
//                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
//                .registerModule(module);
//    }
//    @Bean
//    @Primary
//    public ObjectMapper objectMapper() {
//        return new ObjectMapper()
//                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    }
//
//    @Bean
//    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
//        return new Jackson2ObjectMapperBuilder().serializers(LOCAL_DATETIME_SERIALIZER)
//                .serializationInclusion(JsonInclude.Include.NON_NULL);
//    }
//
//    @Bean
//    public MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter() {
//        return new MappingJackson2XmlHttpMessageConverter(
//                new Jackson2ObjectMapperBuilder()
//                        .defaultUseWrapper(false)
//                        .createXmlMapper(true)
//                        .build()
//        );
//    }



//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer customBuilder() {
//        return builder -> {
//            builder.serializationInclusion(JsonInclude.Include.NON_NULL);
//        }
//    }

}
