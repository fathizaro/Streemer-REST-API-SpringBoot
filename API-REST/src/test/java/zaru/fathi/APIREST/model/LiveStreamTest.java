package zaru.fathi.APIREST.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LiveStreamTest {
    @Test
    void create_new_mutable_live_stream(){
        MutableLiveStream stream= new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Building REST APIs with Spring Boot");
        stream.setDescription("""
                Spring Boot provides a good platform for Java developers to develop a 
                stand-alone and production-grade spring application that you can just run.
                You can get started with minimum configurations without the need for an entire
                 Spring configuration setup.
                """);
        stream.setUrl("https://www.twitch.tv/FathiZaru");
        stream.setStartDate(LocalDateTime.of(2022,2,16,11,10));
        stream.setEndDate(LocalDateTime.of(2022,2,16,11,11));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot",stream.getTitle());

    }


    @Test
    void create_new_immutable_live_stream(){
        ImmutableLiveStream stream= new ImmutableLiveStream(
        UUID.randomUUID().toString(),
        "Building REST APIs with Spring Boot",
     """
                Spring Boot provides a good platform for Java developers to develop a 
                stand-alone and production-grade spring application that you can just run.
                You can get started with minimum configurations without the need for an entire
                 Spring configuration setup.
                """,
        "https://www.twitch.tv/FathiZaru",
       LocalDateTime.of(2022,2,16,11,10),
        LocalDateTime.of(2022,2,16,11,11));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot",stream.getTitle());

    }

    @Test
    void create_new_recored_live_stream(){
        LiveStream stream= new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST APIs with Spring Boot",
                """
                           Spring Boot provides a good platform for Java developers to develop a 
                           stand-alone and production-grade spring application that you can just run.
                           You can get started with minimum configurations without the need for an entire
                            Spring configuration setup.
                           """,
                "https://www.twitch.tv/FathiZaru",
                LocalDateTime.of(2022,2,16,11,10),
                LocalDateTime.of(2022,2,16,11,11));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot",stream.title());
        assertTrue(stream.getClass().isRecord());
        assertEquals(6,stream.getClass().getRecordComponents().length);
    }




}
