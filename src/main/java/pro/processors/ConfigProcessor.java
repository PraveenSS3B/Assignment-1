package pro.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pro.dao.Student;

@Configuration
public class ConfigProcessor {
	Logger log = LoggerFactory.getLogger(ConfigProcessor.class);

	@Bean
	public ItemProcessor<Student, Student> processor() {
		log.trace("Processing the students having marks less than 65!");
		return student -> {
			if (student.getMarks() < 65)
				return student;
			return null;
		};
	}

}
