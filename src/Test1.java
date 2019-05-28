class MoneyTransactionUtil {
    private MoneyTransactionUtil() {
    }

    static void sendTo(int numberCard, int numberCard1, int sum) throws RuntimeException {
        if (numberCard == numberCard1) {
            throw new RuntimeException("Impossible to send money on this account");

        }
        if (sum == 0 || sum < 0 || sum > 100_000) {
            throw new RuntimeException("You have overreached the top of available limit");
        }

        System.out.println("Сумма " +" "+ sum + ", со счета " +" "+ numberCard + " успешно переведена на счет" +" "+ numberCard1);

    }


    public static void main(String[] args) {

        try {
            sendTo(234556, 2342356, 1000);
        } catch (RuntimeException e) {
            System.out.println("При обработке\n" +
                    "транзакции банка произошла ошибка");
        }
    }
}

