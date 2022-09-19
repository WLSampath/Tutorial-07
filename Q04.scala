//Q4
class Account(acc: String, bal: Double){

  var accountNo = acc
  var balance = bal      
            
  def isNegativeBalance() = if (balance < 0) true else false
  
  def addInterest(depositRate: Double, overdraftRate: Double) = balance = balance * (1 + (if(isNegativeBalance()) overdraftRate else depositRate))
  
  override def toString = "\nAccount : " + accountNo + "\nBalance : " + balance
            
}

object Bank extends App{

    var accounts: List[Account] = List( // created 3 Account objects and add to array
    Account("001", -1000.0), 
    Account("002", 3000.0), 
    Account("003", 4000.0)
    )

    println("\n-------------------------------------------------------------------------")
    println("List of Accounts with negative balances : ")
    val negativeBalances = accounts.filter(account => account.isNegativeBalance()) // map account objects and calling isNegative() for each account
    negativeBalances.map(account => println(account))
    
    println("\n-------------------------------------------------------------------------")
    println("The sum of all account balances : ")
    val total = accounts.reduce((x, y) => Account("-TOTAL-", x.balance + y.balance)) // create an account object and total balance add to the object
    println(total)
    
    println("\n-------------------------------------------------------------------------")
    println("The final balances of all accounts after apply the interest : ")
    accounts.map(account => account.addInterest(0.05, 0.1)) // map all accounts and calculate interests
    accounts.map(account => println(account))
    

}
