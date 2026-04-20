package com.example.basededatosconectada;

import com.example.basededatosconectada.models.alumno;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class AlumnoDAOImpl implements AlumnoDAO {
    private final MongoCollection<alumno> collection;

    public AlumnoDAOImpl() {
        // Configuración para mapeo automático de POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClient mongoClient = MongoClients.create("mongodb://localhost: 27017");
        MongoDatabase database = mongoClient.getDatabase("aula").withCodecRegistry(pojoCodecRegistry);
        this.collection = database.getCollection("alumnos", alumno.class);
    }

    @Override
    public List<alumno> obtenerTodos() {
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Optional<alumno> obtenerPorId(String id) {
        alumno alumno = collection.find(new org.bson.Document("_id", new ObjectId(id))).first();
        return Optional.ofNullable(alumno);
    }

    @Override
    public void guardar(alumno alumno) {
        if (alumno.getId() == null) {
            collection.insertOne(alumno);
        } else {
            collection.replaceOne(new org.bson.Document("_id", alumno.getId()), alumno);
        }
    }

    @Override
    public void eliminar(String id) {
        collection.deleteOne(new org.bson.Document("_id", new ObjectId(id)));
    }
}
