// Task 7.7.2: contact database, using a map
fun readContacts() = buildMap<String, String> {
    print("Enter contacts (name and phone number): ")
    while (true) {
        val line = readln()
        if (line.isEmpty()) break
        val parts = line.split(" ")
        if (parts.size == 2) {
            val name = parts[0]
            val phone = parts[1]
            this[name] = phone
        }
    }
}

fun displayContacts(contacts: MutableMap<String, String>) {
    if (contacts.isEmpty()) {
        println("No contacts to display.")
        return
    }

    while (true) {
        print("Enter a name to search (or press Enter to exit): ")
        val name = readln()
        if (name.isEmpty()) break
        val phone = contacts[name]
        if (phone != null) {
            println("Phone number for $name: $phone")
        } else {
            print("Contact not found. Enter phone number to add new contact: ")
            val number = readln()
            contacts[name] = number
        }
    }
}

fun main() {
    val contacts = readContacts().toMutableMap()
    displayContacts(contacts)
}