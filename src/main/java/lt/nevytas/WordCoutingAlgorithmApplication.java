package lt.nevytas;

import lt.nevytas.service.CountingAlgorithmService;
import lt.nevytas.service.FileOutputService;
import lt.nevytas.service.WordCountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Map;

@SpringBootApplication
public class WordCoutingAlgorithmApplication implements CommandLineRunner {
    @Autowired
    private CountingAlgorithmService countingAlgorithmService;
	public static void main(String[] args) {
		SpringApplication.run(WordCoutingAlgorithmApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//	    countingAlgorithmService.getWordCountMap();
        String outputDirectory = "C:\\Users\\nevyt\\Documents\\word-couting-algorithm\\src\\main\\resources\\output\\";
        Map<String, Integer> wordMap = countingAlgorithmService.getWordCountMap();
        FileOutputService foService1 = new FileOutputService('a','g',outputDirectory,"fromAtoG.txt",wordMap);
        FileOutputService foService2 = new FileOutputService('h','n',outputDirectory,"fromHtoN.txt",wordMap);
        FileOutputService foService3 = new FileOutputService('o','u',outputDirectory,"fromOtoU.txt",wordMap);
        FileOutputService foService4 = new FileOutputService('v','z',outputDirectory,"fromVtoZ.txt",wordMap);
        Thread t1 = new Thread(foService1);
        Thread t2 = new Thread(foService2);
        Thread t3 = new Thread(foService3);
        Thread t4 = new Thread(foService4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
	}
}
