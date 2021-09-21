package actions;


import bank.User;
import client.MongoClientProvider;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Iterator;

public class Operations {
    public void InserUser (String name, String surname){
        MongoClient mongoClient =  MongoClientProvider.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("Bank");
        MongoCollection<Document> collection = database.getCollection("Users");

        Document document = new Document("vardas", name);
        document.append("pavarde", surname)
                .append("balance", 0);

        collection.insertOne(document);

        mongoClient.close();
    }

    public User findUser (String name, String surname){
        MongoClient client = (MongoClient) MongoClientProvider.getClient();
        MongoDatabase database = client.getDatabase("Bank");
        MongoCollection<User> collection = database.getCollection("users", User.class);

        Iterator<User> iterator = collection.find(Filters.and(Filters.eq("name", name), Filters.eq("surname", surname))).iterator();

        return iterator.next();
    }
}
