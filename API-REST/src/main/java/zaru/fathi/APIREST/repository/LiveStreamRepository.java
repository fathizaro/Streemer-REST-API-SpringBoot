package zaru.fathi.APIREST.repository;

import org.springframework.stereotype.Repository;
import zaru.fathi.APIREST.model.LiveStream;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
@Repository
public class LiveStreamRepository {
    List<LiveStream> streams = new ArrayList<>();
    public LiveStreamRepository() {
       streams.add( new LiveStream(
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
                LocalDateTime.of(2022,2,16,11,11)));



    }
    public List<LiveStream> findAll(){
        return streams;
    }
    public LiveStream findById(String id){
        return streams.stream().filter(stream -> stream.id().equals(id)).findFirst().orElse(null);

    }
    public LiveStream create (LiveStream stream){
       streams.add(stream);
        return stream;
    }

    public void update(LiveStream stream, String id){
        LiveStream existing = streams.stream().filter(s -> s.id().equals(id)).
                findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Stream not found"));
        int i =streams.indexOf(existing);
        streams.set(i,stream);


    }

    public void delete (String id){
        streams.removeIf(stream -> stream.id().equals(id));
    }
}
