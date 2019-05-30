 class AccountException extends RuntimeException {

     public AccountException(String s) {
     }
 }
class MoneyValueExertion extends RuntimeException{


    static void sendTo(int numberCard, int numberCard1, int sum) throws AccountException {
        if (numberCard == numberCard1) {
            throw new AccountException("Impossible to send money on this account");

        }
        if (sum == 0 || sum < 0 || sum > 100_000) {
            throw new AccountException("You have overreached the top of available limit");
        }

        System.out.println("Сумма " +" "+ sum + ", со счета " +" "+ numberCard + " успешно переведена на счет" +" "+ numberCard1);

    }


    public static void main(String[] args) {

        try {
            sendTo(234556, 2342356, 1000);
        } catch (AccountException e) {
            System.out.println("При обработке\n" +
                    "транзакции банка произошла ошибка");
        }
    }
}
