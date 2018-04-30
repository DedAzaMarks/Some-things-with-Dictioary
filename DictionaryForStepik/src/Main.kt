import java.util.*
val scan = java.util.Scanner(System.`in`)

//prints all commands
fun commandReminder () {
    println("1 - Add a key and value")
    println("2 - Delete a key value pair")
    println("3 - Find a key or value")
    println("4 - print all pairs")
    println("5 - Call reminder")
    println("6 - Terminate the proces")
    println("========================================================================")
}

//gets key and value and makes a pair
fun addPair (map: TreeMap<Int,String>):TreeMap<Int, String> {
    println("Add a key value pair")
    println("------------------------------------------------------------------------")
    val key: Int
    //if user want to input not an int key
    //he'll be thrown to the begin
    try {
        println("Give a key (int)")
        //gets key
        key = scan.nextInt()
        println("Give a value (string)")
        //creates a pair with key
        map[key] = scan.next()
        println("$key : ${map[key]}\nWas added")
        println("------------------------------------------------------------------------")
        println("What's next?")
    }
    catch (e: Exception) {println("?")}
    return map
}

//asks what should we use
//if key we delete the pair with such key
//if value we delete all pairs with such value
fun deletePair(map: TreeMap<Int, String>): TreeMap<Int,String> {
    println("Delete a pair")
    println("------------------------------------------------------------------------")
    //check the size
    if (map.size == 0) {
        println("There is no pairs")
        println("------------------------------------------------------------------------")
    }
    else {
        println("Delete a key value pair by key or by value (1 - key (int) and 2 - value)")
        try {
            val way = scan.nextInt()
            //check for the variant
            when (way) {
                1 -> {
                    try {
                        println("Give a key (int)")
                        val key = scan.nextInt()
                        if (map.containsKey(key)) {
                            println("$key : ${map[key]}\nWas deleted")
                            map.remove(key)
                            println("------------------------------------------------------------------------")
                            println("What's next?")
                        } else {
                            println("There is no such key")
                            println("------------------------------------------------------------------------")
                            println("What's next?")
                        }
                    } catch (e: Exception) {
                    }
                }
                2 -> {
                    println("Give value")
                    val str = scan.next()
                    if (map.containsValue(str)) {
                        for ((key, value) in map) {
                            if (value == str) {
                                println("$key : $str\nWas deleted")
                                map.remove(key)
                            }
                        }
                        println("Was deleted")
                        println("------------------------------------------------------------------------")
                        println("What's next?")
                    } else {
                        println("Value is not found")
                        println("------------------------------------------------------------------------")
                        println("What's next?")
                    }
                }
                else -> {
                    println("No such variant")
                    println("?")
                }
            }
        }
        catch (e: Exception) {println("?")}
    }
    return map
}

//asks what should we use
//if key we print the pair with such key
//if value we print all pairs with such value
fun findPair(map: TreeMap<Int, String>) {
    println("Find a pair")
    println("------------------------------------------------------------------------")
    if (map.size == 0) {
        println("There is no pairs")
        println("------------------------------------------------------------------------")
    }
    else {
        println("Look for pair by key or bt value (1 - key (int) and 2 - value)")
        try {
            val way = scan.nextInt()
            when (way) {
                1 -> {
                    try {
                        println("Give a key (int)")
                        val key = scan.nextInt()
                        if (map.containsKey(key)) {
                            println("$key : ${map[key]}\nWas found")
                            println("------------------------------------------------------------------------")
                            println("What's next?")
                        } else {
                            println("The key is not found")
                            println("------------------------------------------------------------------------")
                            println("What's next?")
                        }
                    } catch (e: Exception) {}
                }
                2 -> {
                    println("Give a value")
                    val str = scan.next()
                    if (map.containsValue(str)) {
                        for ((key, value) in map)
                            if (value == str) {
                                println("$key : $str\nWas found")
                                println("------------------------------------------------------------------------")
                                println("What's next?")
                            }
                    } else println("The value was not found")
                }
                else -> println("No such variant")
            }
        } catch (e: Exception) {println("?")}
    }
}

//prints all pairs
//if the exists
fun printPairs(map: TreeMap<Int,String>) {
    println("Print all pairs")
    println("------------------------------------------------------------------------")
    if (map.size == 0) {
        println("There is no key value pairs")
        println("------------------------------------------------------------------------")
        println("What's next?")
    }
    else {
        for ((key, value) in map)
            println("$key : $value")
        println("------------------------------------------------------------------------")
        println("What's next?")
    }
}

fun main (args: Array<String>) {
    var map = TreeMap<Int, String>()
    var cmmd :String
    println("Hello, this is a Key Value Pair.")
    println("To make your life easier each command will be just a number-key")
    println("So, now you have an empty Key Value Pair, what do you want to do?")
    commandReminder()
    do {
        //look for dif
        cmmd = scan.next()
        when (cmmd) {
            "1" -> addPair(map)
            "2" -> deletePair(map)
            "3" -> findPair(map)
            "4" -> printPairs(map)
            "5" -> commandReminder()
            "6" -> println("Good bey")
            else -> println("?")
        }
    } while (cmmd != "6")
}
