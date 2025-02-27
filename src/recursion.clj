(ns recursion)

(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll)
       (product (rest coll)))))

(defn singleton? [coll]
  (if (empty? coll)
    false
    (if (empty? (rest coll))true false)))

(defn my-last [coll]
  (if (empty? coll)
    nil
    (if (singleton? coll)
      (first coll)
      (my-last (rest coll)))))

(defn max-element [a-seq]
  (if (empty? a-seq)
    nil
    (if (singleton? a-seq)
      (first a-seq)
      (max (first a-seq) (max-element (rest a-seq))))))

(defn seq-max [seq-1 seq-2]
    (if (> (count seq-1) (count seq-2)) seq-1 seq-2))

(defn longest-sequence [a-seq]
  (if (empty? a-seq)
    nil
    (if (singleton? a-seq)
      (first a-seq)
      (seq-max (first a-seq) (longest-sequence (rest a-seq))))))

(defn my-filter [pred? a-seq]
  (if (empty? a-seq)
    a-seq
    (if (pred? (first a-seq))
      (cons (first a-seq) (my-filter pred? (rest a-seq)))
      (my-filter pred? (rest a-seq)))))
(defn sequence-contains? [elem a-seq]
  (cond
    (empty? a-seq)
    false
    (= elem (first a-seq))
    true
    :else
    (sequence-contains? elem (rest a-seq))))


(defn my-take-while [pred? a-seq]
  (cond
    (empty? a-seq)
    '()
    (pred? (first a-seq))
    (cons (first a-seq) (my-take-while pred? (rest a-seq)))
    :else '()))


(defn my-drop-while [pred? a-seq]
  (cond
    (empty? a-seq)
    '()
    (pred? (first a-seq))
    (my-drop-while pred? (rest a-seq))
    :else
    a-seq))

(defn seq= [a-seq b-seq]
  (cond
    (and (empty? a-seq) (empty? b-seq))
    true
    (= (first a-seq) (first b-seq))
    (seq= (rest a-seq) (rest b-seq))
    :else false))

(defn my-map [f seq-1 seq-2]
  (if (or (empty? seq-2) (empty? seq-1))
    '()
    (cons (f (first seq-1) (first seq-2)) (my-map f (rest seq-1) (rest seq-2)))))



(defn power [n k]
  (if (= k 0)
    1
    (* n (power n (dec k)))))


(defn fib [n]
  (cond
    (= n 0)
    0
    (= n 1)
    1
    :else
    (+ (fib (dec n)) (fib (- n 2)))))



(defn my-repeat [how-many-times what-to-repeat]
  (if (<= how-many-times 0)
    '()
    (cons what-to-repeat (my-repeat (dec how-many-times) what-to-repeat))))

(defn my-range [up-to]
  (if (= up-to 0)
    '()
    (cons (dec up-to) (my-range (dec up-to)))))

(defn tails [a-seq]
  (if (empty? a-seq)
    (list ())
    (cons (apply list a-seq) (tails (rest a-seq)))))

(defn inits [a-seq]
  (if (empty? a-seq)
    (list ())
    (cons (apply list a-seq) (inits (reverse (rest (reverse a-seq)))))))

(defn rotations [a-seq]
  (into '() (set (map #(concat %1 %2) (tails a-seq) (reverse (inits a-seq))))))

(defn my-frequencies-helper [freqs a-seq]
  (if (empty? a-seq)
    freqs
    (let [current-element (first a-seq)
          current-element-count (get freqs current-element)
          new-count (if (nil? current-element-count)
                      1
                      (inc current-element-count))]
         (my-frequencies-helper (assoc freqs current-element new-count) (rest a-seq)))))

(defn my-frequencies [a-seq]
  (my-frequencies-helper {} a-seq))

(defn un-frequencies [a-map]
  (if (empty? a-map)
    '()
    (concat (repeat (val (first a-map)) (key (first a-map))) (un-frequencies (rest a-map)))))

(defn my-take [n coll]
  (if (or (empty? coll) (zero? n))
    '()
    (cons (first coll) (my-take (dec n) (rest coll)))))

(defn my-drop [n coll]
  (if (or (empty? coll) (zero? n))
    coll
    (my-drop (dec n) (rest coll))))

(defn halve [a-seq]
  (let [half-length (int (/ (count a-seq) 2))]
    (vector (my-take half-length a-seq) (my-drop half-length a-seq))))

(defn seq-merge [a-seq b-seq]
  (cond
    (and (empty? a-seq) (empty? b-seq))
    '()

    (empty? a-seq)
    (cons (first b-seq) (seq-merge a-seq (rest b-seq)))

    (empty? b-seq)
    (cons (first a-seq) (seq-merge (rest a-seq) b-seq))

    (> (first a-seq) (first b-seq))
    (cons (first b-seq) (seq-merge a-seq (rest b-seq)))

    (= (first a-seq) (first b-seq))
    (cons (first a-seq) (seq-merge (rest a-seq) b-seq))

    :else
    (cons (first a-seq) (seq-merge (rest a-seq) b-seq))))



(defn merge-sort [a-seq]
    (cond
      (= (count a-seq) 0)
      '()
      (= (count a-seq) 1)
      a-seq
      :else
      (seq-merge (merge-sort (get (halve a-seq) 0)) (merge-sort (get (halve a-seq) 1)))))



(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])