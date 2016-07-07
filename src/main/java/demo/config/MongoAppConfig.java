package demo.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoAppConfig {
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException{
		MongoClientURI uri = new MongoClientURI("mongodb://192.168.175.131:27017/cursos");
		return new SimpleMongoDbFactory(new MongoClient(uri), "cursos");
	}
	
//	Syntax of the URI is as follows:
//		mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][?options]]
	
	
	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException{
		return new MongoTemplate(mongoDbFactory());
	}

}
