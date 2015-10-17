(ns binary.core
  (:gen-class))


;; A binary tree node with a value
(defrecord Tree [^long key
                 left
                 right])

(defn leaf
  "Creates a leaf of a tree with key key"
  [^long key]
  (->Tree key nil nil)
  )


(defn insert
  "Inserts key into the given binary tree"
  [tree
   ^long key
   ]
  (if (> (:key tree) key)
    (if (nil? (:left tree))
      (assoc tree :left (leaf key))
      (assoc tree :left (insert (:left tree) key)))
    (if (nil? (:right tree))
      (assoc tree :right (leaf key))
      (assoc tree :right (insert (:right tree) key)))))

(defn search
  "Searches for key in tree"
  [tree
   ^long key
   ]
  (if (= (:key tree) key)
    tree
    (if (> (:key tree) key)
      (if (nil? (:left tree))
        nil
        (search (:left tree) key))
      (if (nil? (:right tree))
        nil
        (search (:right tree) key)))))

(defn delete-first
  "Deletes the node with the smallest key from tree"
  [tree]
  (if (nil? (:left tree))
    (:right tree)
    (assoc tree :left (delete-first (:left tree)))))

(defn minkey
  "Returns the smallest key"
  [tree]
  (loop [t tree]
    (if (nil? (:left t))
      (:key t)
      (recur (:left t)))))

(defn delete-root
  "Deletes the root of the tree tree."
  [tree]
  (if (nil? (:left tree))
    (:right tree)
    (if (nil? (:right tree))
      nil
      (->Tree (minkey (:right tree)) (:left tree) (delete-first (:right tree))))))

(defn delete
   "Deletes the highest instance of key from tree"
   [tree
    ^long key
    ]
  (if (= key (:key tree))
    (delete-root tree)
    (if (> (:key tree) key)
      (if (nil? (:left tree))
        nil
        (assoc tree :left (delete (:left tree) key)))
      (if (nil? (:right tree))
        nil
        (assoc tree :right (delete (:right tree) key))))))


(defn traverse [tree]
  (loop [t tree se (transient [])]
    (if (nil? t)
      (persistent! se)
      (recur (delete-first t) (conj! se (minkey t))))))



(defn multipleInsert
  [bTree
   ^longs values
   ]
  (loop [t  bTree vs values]
    (if (empty? vs)
       t
       (recur (insert t (first vs)) (rest vs)))))

(defn genrand
  ^ints
  [n]
  (loop [i n acc (transient [])]
    (if (zero? i)
      (persistent! acc)
      (recur (- i 1) (conj! acc (rand-int 10000))))))


(defn eat [n])
(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (def speedtesta (leaf 5000))
  (def r (genrand 100000))
  (eat (time (multipleInsert speedtesta r)))
  )
