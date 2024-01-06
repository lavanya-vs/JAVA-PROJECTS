package project;

import java.util.Scanner;

public class MINI_proj_1 {

	class DB {
		private static final String storedUsername = "admin";
		private static final String storedPassword = "admin";

		public static String getUsername() {
			return storedUsername;
		}

		public static String getPassword() {
			return storedPassword;
		}

	}

	class LoginSystem {
		public static void loginCredentials() {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter user name");
			String enterUsername = sc.next();

			if (enterUsername.equals(DB.getUsername())) {
				System.out.println("enter your password");
				String enterPassword = sc.next();

				if (enterPassword.equals(DB.getPassword())) {
					System.out.println("welcome ");
				}

				else {
					System.out.println("wrong password.Login failed");
				}
			} else {
				System.out.println("invalid username");
			}
		}
	}

	public double balance;
	public static final double min_bal = 1000.0;

	public MINI_proj_1() {

		balance = min_bal;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited: rupees " + amount);
			System.out.println("Updated Balance: rupees " + balance);
		} else {
			System.out.println("Invalid amount for deposit.");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && (balance - amount) >= min_bal) {
			balance -= amount;
			System.out.println("Withdrawn: rupees " + amount);
			System.out.println("Updated Balance: rupees " + balance);
		} else {
			System.out.println(" minimum balance has to be maintained");
		}
	}

	public void checkBalance() {
		System.out.println("Balance: rupees " + balance);
	}

	public static void main(String[] args) {
		LoginSystem.loginCredentials();
		MINI_proj_1 obj = new MINI_proj_1();
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Balance Enquiry");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter deposit amount: rupees ");
				double depositAmount = scanner.nextDouble();
				obj.deposit(depositAmount);
				break;
			case 2:
				System.out.print("Enter withdrawal amount: rupees ");
				double withdrawAmount = scanner.nextDouble();
				if (withdrawAmount > obj.balance - min_bal) {
					System.out.println("Withdrawal amount exceeds balance.");
				} else {
					obj.withdraw(withdrawAmount);
				}
				break;
			case 3:
				obj.checkBalance();
				break;
			case 4:
				System.out.println(" Thank you");
				break;
			default:
				System.out.println("Invalid choice.");
			}

		} while (choice != 4);

	}
}
