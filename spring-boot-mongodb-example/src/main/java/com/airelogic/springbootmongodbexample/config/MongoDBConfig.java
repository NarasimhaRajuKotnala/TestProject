package com.airelogic.springbootmongodbexample.config;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.airelogic.springbootmongodbexample.models.Bug;
import com.airelogic.springbootmongodbexample.models.Comment;
import com.airelogic.springbootmongodbexample.models.History;
import com.airelogic.springbootmongodbexample.models.User;
import com.airelogic.springbootmongodbexample.repositories.BugRepository;
import com.airelogic.springbootmongodbexample.repositories.CommentRepository;
import com.airelogic.springbootmongodbexample.repositories.HistoryRepository;
import com.airelogic.springbootmongodbexample.repositories.UserRepository;

@EnableMongoRepositories(basePackageClasses=UserRepository.class)
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MongoDBConfig {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BugRepository bugRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	HistoryRepository historyRepository;
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				//To start with some initial users in the MongoDB database
				userRepository.save(new User("Narasimha", "Kotnala", "narasimha.kotnala@yahoo.com","kot"));
				userRepository.save(new User("Rachel", "Lintott","rachel.lintott@yahoo.com","lint"));
				userRepository.save(new User("Matthew", "Stewart","matthew.stewart@yahoo.com","stew"));
				userRepository.save(new User("Richard", "Joseph","richard.joseph@yahoo.com","rjos"));
				userRepository.save(new User("Monika", "Verma","monika.verma@yahoo.com","verma"));
				
				
				//Initial Bugs in the Sytem
				String[] strArrayViwedBy = new String[]{"Tester1","Tester2","Tester3"};
				String[] strArrayWatchers = new String[]{"Stakeholder1","Stakeholder2","Stakeholder3"};
				String[] strArrayTags = new String[]{"Tag1","Tag2","Tag3"};
				String[] strArrayComments = new String[]{"Comment1","Comment2","Comment3"};
				
				bugRepository.save(
						
						new Bug("SQL",
								"SQL INSERT ERROR",
								LocalDateTime.now(),
								LocalDate.now().plusDays(5),
								"Narasimha",
								userRepository.findByFirstName("Narasimha").getId(),
								strArrayViwedBy,
								strArrayWatchers,
								"High",
								strArrayTags,
								strArrayComments,
								"NEW")
						);
				
				bugRepository.save(
						
						new Bug("SERVER",
								"SERVER ERROR",
								LocalDateTime.now(),
								LocalDate.now().plusDays(5),
								"Rachel",
								userRepository.findByFirstName("Rachel").getId(),
								strArrayViwedBy,
								strArrayWatchers,
								"Medium",
								strArrayTags,
								strArrayComments,
								"IN PROGRESS")
						);
				
				
				
				commentRepository.save(
						
						new Comment(
								bugRepository.findByUserId(userRepository.findByFirstName("Narasimha").getId()).getId(),
								"A critical bug needs external support",
								LocalDateTime.now(),
								userRepository.findByFirstName("Narasimha").getId()
								)
						
						);
				
				commentRepository.save(
						
						new Comment(
								bugRepository.findByUserId(userRepository.findByFirstName("Rachel").getId()).getId(),
								"A critical bug needs external support",
								LocalDateTime.now(),
								userRepository.findByFirstName("Rachel").getId()
								)
						
						);
				
				historyRepository.save(
						new History(
								userRepository.findByFirstName("Narasimha").getId(),
								userRepository.findByFirstName("Narasimha").getId(),
								"Added Comment",
								LocalDateTime.now()
								)
						
						);
				
				
				historyRepository.save(
						new History(
								userRepository.findByFirstName("Rachel").getId(),
								userRepository.findByFirstName("Rachel").getId(),
								"Updated Comment",
								LocalDateTime.now()
								)
						
						);
				
					
			 }
			
		};
	}

}
