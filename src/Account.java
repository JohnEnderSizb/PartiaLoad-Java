public class Account{
	private String accountName;
    private String ledgerBalance;
    private String availableBalance;

	public Account(String accountName, String ledgerBalance, String availableBalance){
			this.accountName = accountName;
			this.ledgerBalance = ledgerBalance;
			this.availableBalance = availableBalance;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public String getLedgerBalance() {
		return this.ledgerBalance;
	}

	public String getAvailableBalance() {
		return this.availableBalance;
	}


}