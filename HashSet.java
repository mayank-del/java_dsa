HashSet<String> hashSet = new HashSet<>();

        // Add elements to the HashSet
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Date");

Iterator<String> iterator = hashSet.iterator();

        // Iterate over the HashSet using hasNext() and next()
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }