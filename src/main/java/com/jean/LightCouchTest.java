package com.jean;

import java.io.InputStream;
import java.util.List;

import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import com.jean.entity.Log;

public class LightCouchTest {

	public static void main(String[] args) {
		CouchDbClient dbClient = new CouchDbClient(); 
//
//		Log log = new Log(); // Plain Java Object
//		log.setId(1);
//		log.setDescription("hola");
//		log.setAuthor("jeanpier");
//
//		Response response = dbClient.save(log);
		Log logFinded = dbClient.find(Log.class, "49f693c436004b958a8535c474940e71");

		System.out.println(logFinded.toString());
//		dbClient.update(logFinded);
//
//		dbClient.remove(logFinded);
//
//		boolean b = dbClient.contains("id");
//
//		System.out.println(b);
//		
//		// views
//		List<Log> list = dbClient.view("ddoc/by_date")
//		 	.key("key")
//		 	.includeDocs(true)
//		 	.query(Log.class);
//		 	
//		long count = dbClient.view("ddoc/by_tag")
//		    .key("couchdb").queryForLong(); 

		// attachments
//		Response response = dbClient.saveAttachment(InputStream, "photo.png", "image/png");
//		InputStream in = dbClient.find("doc-id/photo.png");
//		in.close();
//
//		// replication
//		ReplicationResult replication = dbClient.replication()
//			.source("source-db").target("target-db")
//			.createTarget(true)
//			.trigger();
//
//		// changes feed
//		Changes changes = dbClient.changes()
//			.includeDocs(true)
//			.heartBeat(30000)
//			.continuousChanges();
//
//		while (changes.hasNext()) {
//			ChangesResult.Row feed = changes.next();
//		}		 	
//
		// shutdown the client
		dbClient.shutdown(); 
	}

}
