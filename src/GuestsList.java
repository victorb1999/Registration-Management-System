import java.util.ArrayList;
import java.util.List;

public class GuestsList {
	private int guestsCapacity;
	private ArrayList<Guest> list = new ArrayList<Guest>();

	public GuestsList(int guestsCapacity) {
		this.guestsCapacity = guestsCapacity;
	}

	public int add(Guest g) {
		if (isOnTheListAlready(g)) {
			return -1;
		} else {
			list.add(g);
			if (list.size() > this.guestsCapacity) {
				System.out.println("[" + g.fullName()
						+ "] Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine "
						+ (list.size() - this.guestsCapacity) + ". Te vom notifica daca un loc devine disponibil.");
				return list.size();
			} else {
				System.out.println(
						"[" + g.fullName() + "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			}
		}

		return 0;
	}

	private boolean isOnTheListAlready(Guest g) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(g)) {
				return true;
			}
		}
		return false;
	}

	public Guest search(String firstName, String lastName) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getLastName().equals(lastName) && list.get(i).getFirstName().equals(firstName)) {
				return list.get(i);
			}
		}

		return null;
	}

	public Guest search(int opt, String match) {
		if (opt == 2) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getEmail().equals(match)) {
					return list.get(i);
				}
			}
		}

		if (opt == 3) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getPhoneNumber().equals(match)) {
					return list.get(i);
				}
			}
		}

		return null;
	}

	public boolean remove(String firstName, String lastName) {
		if (isOnTheListAlready(search(firstName, lastName))) {
			Guest toRemove = search(firstName, lastName);
			if (list.indexOf(toRemove) < this.guestsCapacity && list.size() > this.guestsCapacity) {
				System.out.println("[" + list.get(guestsCapacity).fullName()
						+ "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			}
			list.remove(toRemove);
			return true;
		}

		return false;
	}

	public boolean remove(int opt, String match) {
		if (isOnTheListAlready(search(opt, match))) {
			Guest toRemove = search(opt, match);
			if (list.indexOf(toRemove) < this.guestsCapacity && list.size() > this.guestsCapacity) {
				System.out.println("[" + list.get(guestsCapacity).fullName()
						+ "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			}
			list.remove(toRemove);
			return true;
		}

		return false;
	}

	public void showGuestsList() {
		if (list.size() > this.guestsCapacity) {
			for (int i = 0; i < this.guestsCapacity; i++) {
				System.out.println(i + 1 + ". " + list.get(i).toString());
			}
		} else {
			int y = 1;
			for (Guest toShow : list) {
				System.out.println(y + ". " + toShow.toString());
				y++;
			}
		}
	}

	public void showWaitingList() {
		if (list.size() > this.guestsCapacity) {
			int z = 1;
			for (int i = guestsCapacity; i < list.size(); i++) {
				System.out.println(z + ". " + list.get(i).toString());
				z++;
			}
		} else {
			System.out.println("Lista de asteptare este goala...");
		}
	}

	public int numberOfAvailableSpots() {
		if (list.size() >= this.guestsCapacity) {
			return 0;
		}
		return this.guestsCapacity - list.size();
	}

	public int numberOfGuests() {
		if (list.size() >= this.guestsCapacity) {
			return this.guestsCapacity;
		}
		return list.size();
	}

	public int numberOfPeopleWaiting() {
		if (list.size() <= this.guestsCapacity) {
			return 0;
		}

		return list.size() - this.guestsCapacity;
	}

	public int numberOfPeopleTotal() {
		return list.size();
	}

	public List<Guest> partialSearch(String match) {
		ArrayList<Guest> partialList = new ArrayList<Guest>();
		match = match.toLowerCase();
		for (Guest item : list) {
			if (item.getEmail().toLowerCase().contains(match) || item.getFirstName().toLowerCase().contains(match)
					|| item.getLastName().toLowerCase().contains(match)
					|| item.getPhoneNumber().toLowerCase().contains(match)) {
				partialList.add(item);
			}

		}

		return partialList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.guestsCapacity + " de persoane se pot inscrie la eveniment. ");
		sb.append(list.size() + "s -au inscris la eveniment. ");
		if (list.size() > this.guestsCapacity) {
			sb.append("Din acestea, " + (list.size() - this.guestsCapacity) + " se afla pe lista de asteptare.");
		}
		return sb.toString();
	}
}
