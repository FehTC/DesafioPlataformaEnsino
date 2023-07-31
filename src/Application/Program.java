package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Lesson;
import Entities.Task;
import Entities.Video;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List <Lesson> list = new ArrayList<> ();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			
			System.out.println("\nDados da " + i + "a aula: ");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char cOrT = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			
			if (cOrT == 'c') {
				
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int duration = sc.nextInt();
				Lesson lesson = new Video(title, url, duration);
				list.add(lesson);
			}
			
			else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int countQuestion = sc.nextInt();
				Lesson lesson = new Task(title, description, countQuestion);
				list.add(lesson);
			}
			
		}
		
		int total = 0;
		for (Lesson l: list) {
			total += l.duration();
		}
		
		System.out.println("\nDURAÇÃO TOTAL DO CURSO = " + total  + " segundos");
		
		sc.close();
	}

}
