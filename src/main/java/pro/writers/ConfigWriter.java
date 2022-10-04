package pro.writers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pro.dao.Student;
import pro.repository.StudentRepository;

@Configuration
public class ConfigWriter {
	Logger log = LoggerFactory.getLogger(ConfigWriter.class);
	@Autowired
	private StudentRepository studentRepository;

	@Bean
	public ItemWriter<Student> writer() {
		log.trace("Writing into Database...");
		return students -> studentRepository.saveAll(students);
	}

}
