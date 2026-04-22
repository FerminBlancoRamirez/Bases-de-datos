package DAO;

import Modelo.Paciente;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class PacienteDAOImpl implements PacientesDAO{
    private final MongoCollection<Paciente> collection;
    public PacienteDAOImpl(){
        CodecRegistry pojoCodecRegistry = fromRegistries(
                getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        MongoClient mongoClient= MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database= mongoClient.getDatabase("Veterinario").
                withCodecRegistry(pojoCodecRegistry);
        this.collection=database.getCollection("pacientes", Paciente.class);
    }

    @Override
    public List<Paciente> obtenerTodos(){
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Optional<Paciente> obtenerPorId(String id){
        Paciente paciente = collection.find(new Document("_id", new ObjectId(id))).first();
        return Optional.ofNullable(paciente);
    }

    @Override
    public void guardar(Paciente paciente) {
        collection.insertOne(paciente);
    }

    @Override
    public void actualizar(Paciente paciente) {
        collection.replaceOne(
                new Document("_id", paciente.getId()),
                paciente
        );
    }

    @Override
    public void eliminar(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }
}
