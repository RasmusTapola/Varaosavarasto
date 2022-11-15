package Varaosavarasto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Varaosavarasto.domain.Auto;
import Varaosavarasto.domain.AutoRepository;
import Varaosavarasto.domain.OsaRepository;
import Varaosavarasto.domain.Osat;
import Varaosavarasto.domain.User;
import Varaosavarasto.domain.UserRepository;

@SpringBootApplication
public class VaraosavarastoApp implements CommandLineRunner {
//public class CarDatabaseWeek3Application {

	//private static final Logger log = LoggerFactory.getLogger(VaraosavarastoApp.class);

	// we need repository interfaces to put demo data to db
	@Autowired
	OsaRepository varaosaRepository;
	
	@Autowired
	AutoRepository autoRepository;
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(VaraosavarastoApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	//	log.info("LUODAAN DEMODATAA");
	//	log.info("Luo muutama omistaja");
		Auto auto1 = new Auto("Matti Meikäläinen", "Mercedez-Benz", "CLS", 2020);
		autoRepository.save(auto1);
		Auto auto2 = new Auto("Mika Saha", "Derbi", "Senda", 1970);
		autoRepository.save(auto2);
		Auto auto3 = new Auto("Harry Potter", "Luuta", "Lentävä", 420);
		autoRepository.save(auto3);

		// Add car object and link to owners and save these to db
		varaosaRepository.save(new Osat("Pakoputki", 2018, 156.25 , 32.952, auto1));
		varaosaRepository.save(new Osat("Nokka-akseli", 2019, 86.39 , 11.842, auto2));
		varaosaRepository.save(new Osat("Jarrupoljin", 2021, 66.95 , 2.23, auto2));
		varaosaRepository.save(new Osat("Takapyörä", 2015, 152.12 , 15.15, auto1));
		varaosaRepository.save(new Osat("Tamminen oksa", 2022, 1337.00 , 1.50, auto3));
		varaosaRepository.save(new Osat("Tokmannin luudan harjakset", 2022, 1.25 , 0.50, auto3));
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		userRepository.save(user1);
		userRepository.save(user2);

	//	log.info("Tulostetaan IDEn konsoliin autot:");
		for (Osat osa : varaosaRepository.findAll()) {
//			log.info(osa.toString());
//			log.info("tämän omistaja on " + osa.getName() + " " + osa.getAuto());
		}

	}

}
