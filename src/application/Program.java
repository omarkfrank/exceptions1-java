package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			try {	
				System.out.print("Número do quarto: ");
				int number = sc.nextInt();
				System.out.print("Data do Check-in (dd/MM/yyyy): ");
				Date checkIn = sdf.parse(sc.next());
				System.out.print("Data do Check-out (dd/MM/yyyy): ");
				Date checkOut = sdf.parse(sc.next());
			
				Reservation reservation = new Reservation(number, checkIn, checkOut);
				System.out.println("Reserva: " + reservation);
				
				System.out.println();
				System.out.println("Informe a data para atualizar a Reserva: ");
				System.out.print("Data do Check-in (dd/MM/yyyy): ");
				checkIn = sdf.parse(sc.next());
				System.out.print("Data do Check-out (dd/MM/yyyy): ");
				checkOut = sdf.parse(sc.next());
			
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reserva: " + reservation);
			}
			catch(ParseException e) {
				System.out.println("Formato de data inválido.");
			}
			catch (DomainException e) {
				System.out.println("Erro na reserva: " + e.getMessage());
			}
			catch (RuntimeException e) {
				System.out.println("Erro inesperado");
			}
		
			sc.close();
		}
	}