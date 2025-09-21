class MovieRentingSystem {
    class Entry {
        int shop, movie, price;
        Entry(int s, int m, int p) {
            shop = s; movie = m; price = p;
        }
    }

    Comparator<Entry> movieComp = (a, b) -> {
        if (a.price != b.price) return a.price - b.price;
        return a.shop - b.shop;
    };

    Comparator<Entry> rentedComp = (a, b) -> {
        if (a.price != b.price) return a.price - b.price;
        if (a.shop != b.shop) return a.shop - b.shop;
        return a.movie - b.movie;
    };

    Map<Integer, TreeSet<Entry>> movieMap; 
    TreeSet<Entry> rentedSet;               
    Map<String, Integer> priceMap;          
    Map<String, Entry> entryMap;            

    public MovieRentingSystem(int n, int[][] entries) {
        movieMap = new HashMap<>();
        rentedSet = new TreeSet<>(rentedComp);
        priceMap = new HashMap<>();
        entryMap = new HashMap<>();

        for (int[] arr : entries) {
            int shop = arr[0], movie = arr[1], price = arr[2];
            Entry e = new Entry(shop, movie, price);

            priceMap.put(shop + "-" + movie, price);
            entryMap.put(shop + "-" + movie, e);

            movieMap.putIfAbsent(movie, new TreeSet<>(movieComp));
            movieMap.get(movie).add(e);
        }
    }


    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!movieMap.containsKey(movie)) return result;

        Iterator<Entry> it = movieMap.get(movie).iterator();
        int k = 5;
        while (it.hasNext() && k-- > 0) {
            result.add(it.next().shop);
        }
        return result;
    }


    public void rent(int shop, int movie) {
        String key = shop + "-" + movie;
        Entry e = entryMap.get(key);

        movieMap.get(movie).remove(e);
        rentedSet.add(e);
    }

    public void drop(int shop, int movie) {
        String key = shop + "-" + movie;
        Entry e = entryMap.get(key);

        rentedSet.remove(e);
        movieMap.get(movie).add(e);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<Entry> it = rentedSet.iterator();
        int k = 5;
        while (it.hasNext() && k-- > 0) {
            Entry e = it.next();
            result.add(Arrays.asList(e.shop, e.movie));
        }
        return result;
    }
}
