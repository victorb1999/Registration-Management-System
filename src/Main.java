import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static void showCommands() {
		System.out.println("help         - Afiseaza aceasta lista de comenzi");
		System.out.println("add          - Adauga o noua persoana (inscriere)");
		System.out.println("check        - Verifica daca o persoana este inscrisa la eveniment");
		System.out.println("remove       - Sterge o persoana existenta din lista");
		System.out.println("update       - Actualizeaza detaliile unei persoane");
		System.out.println("guests       - Lista de persoane care participa la eveniment");
		System.out.println("waitlist     - Persoanele din lista de asteptare");
		System.out.println("available    - Numarul de locuri libere");
		System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
		System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
		System.out.println("subscribe_no - Numarul total de persoane inscrise");
		System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
		System.out.println("save         - Salveaza lista cu invitati");
		System.out.println("restore      - Completeaza lista cu informatii salvate anterior");
		System.out.println("reset        - Sterge informatiile salvate despre invitati");
		System.out.println("quit         - Inchide aplicatia");
	}

	private static void addNewGuest(Scanner sc, GuestsList list) {
		String lastName = sc.nextLine();
		String firstName = sc.nextLine();
		String email = sc.nextLine();
		String phoneNumber = sc.nextLine();
		Guest addNew = new Guest(lastName, firstName, email, phoneNumber);
		list.add(addNew);
	}

	private static void checkGuest(Scanner sc, GuestsList list) {
		Guest unknown = null;
		int option = sc.nextInt();
		if (option == 1) {
			sc.nextLine();
			String lastName = sc.nextLine();
			String firstName = sc.nextLine();
			unknown = list.search(firstName, lastName);
			System.out.println(unknown.toString());
		} else if (option == 2) {
			sc.nextLine();
			String email = sc.nextLine();
			unknown = list.search(option, email);
			System.out.println(unknown.toString());
		} else if (option == 3) {
			sc.nextLine();
			String phoneNumberToSearch = sc.nextLine();
			unknown = list.search(option, phoneNumberToSearch);
			System.out.println(unknown.toString());
		}
	}

	private static void removeGuest(Scanner sc, GuestsList list) {
		int option = sc.nextInt();
		if (option == 1) {
			sc.nextLine();
			String lastName = sc.nextLine();
			String firstName = sc.nextLine();
			list.remove(firstName, lastName);
		} else if (option == 2) {
			sc.nextLine();
			String email = sc.nextLine();
			list.remove(option, email);
		} else if (option == 3) {
			sc.nextLine();
			String phoneNumberToSearch = sc.nextLine();
			list.remove(option, phoneNumberToSearch);
		}
	}

	private static void updateGuest(Scanner sc, GuestsList list) {
		Guest toUpdate = null;
		int option = sc.nextInt();
		if (option == 1) {
			sc.nextLine();
			String lastName = sc.nextLine();
			String firstName = sc.nextLine();
			toUpdate = list.search(firstName, lastName);
		} else if (option == 2) {
			sc.nextLine();
			String email = sc.nextLine();
			toUpdate = list.search(option, email);
		} else if (option == 3) {
			sc.nextLine();
			String phoneNumberToSearch = sc.nextLine();
			toUpdate = list.search(option, phoneNumberToSearch);
		}

		int fieldToUpdate = sc.nextInt();

		if (fieldToUpdate == 1) {
			sc.nextLine();
			String lastNameUpdate = sc.nextLine();
			toUpdate.setLastName(lastNameUpdate);
		} else if (fieldToUpdate == 2) {
			sc.nextLine();
			String firstNameUpdate = sc.nextLine();
			toUpdate.setFirstName(firstNameUpdate);
		} else if (fieldToUpdate == 3) {
			sc.nextLine();
			String emailUpdate = sc.nextLine();
			toUpdate.setEmail(emailUpdate);
		} else if (fieldToUpdate == 4) {
			sc.nextLine();
			String phoneUpdate = sc.nextLine();
			toUpdate.setPhoneNumber(phoneUpdate);
		}
	}

	private static void searchList(Scanner sc, GuestsList list) {
		String matchString = sc.nextLine();
		ArrayList<Guest> partialList = new ArrayList<Guest>();
		partialList.addAll(list.partialSearch(matchString));
		for (int i = 0; i < partialList.size(); i++) {
			System.out.println(partialList.get(i));
		}

		if (partialList.size() == 0) {
			System.out.println("Nothing found");
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		scanner.nextLine();

		GuestsList list = new GuestsList(size);

		boolean running = true;
		while (running) {
			String command = scanner.nextLine();

			switch (command) {
			case "help":
				showCommands();
				break;
			case "add":
				addNewGuest(scanner, list);
				break;
			case "check":
				checkGuest(scanner, list);
				break;
			case "remove":
				removeGuest(scanner, list);
				break;
			case "update":
				updateGuest(scanner, list);
				break;
			case "guests":
				list.showGuestsList();
				break;
			case "waitlist":
				list.showWaitingList();
				break;
			case "available":
				System.out.println("Numarul de locuri ramase: " + list.numberOfAvailableSpots());
				break;
			case "guests_no":
				System.out.println("Numarul de participanti: " + list.numberOfGuests());
				break;
			case "waitlist_no":
				System.out.println("Dimensiunea listei de asteptare: " + list.numberOfPeopleWaiting());
				break;
			case "subscribe_no":
				System.out.println("Numarul total de persoane: " + list.numberOfPeopleTotal());
				break;
			case "search":
				searchList(scanner, list);
				break;
			case "quit":
				System.out.println("Aplicatia se inchide...");
				scanner.close();
				running = false;
				break;
			default:
				System.out.println("Comanda introdusa nu este valida.");
				System.out.println("Incercati inca o data.");

			}
		}
	}
}