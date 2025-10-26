class Bank {
    private long[] balance;  // stores all account balances

    public Bank(long[] balance) {
        this.balance = balance;
    }

    // Helper function to check if account is valid
    private boolean valid(int account) {
        return account >= 1 && account <= balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!valid(account1) || !valid(account2)) return false;
        if (balance[account1 - 1] < money) return false;

        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!valid(account)) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!valid(account)) return false;
        if (balance[account - 1] < money) return false;

        balance[account - 1] -= money;
        return true;
    }
}
