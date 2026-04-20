package com.example.basededatosconectada.Repositories;

import com.example.basededatosconectada.models.alumno;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class AlumnoRepository {
    private final MongoCollection<alumno> collection;

    public AlumnoRepository() {
        // Configuración para que MongoDB entienda clases Java (POJOs)
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("aula").withCodecRegistry(pojoCodecRegistry);
        this.collection = database.getCollection("alumnos", alumno.class);
    }

    public List<alumno> findAll() {
        return collection.find().into(new ArrayList<>());
    }

    public void save(alumno alumno) {
        collection.insertOne(alumno);
    }
}