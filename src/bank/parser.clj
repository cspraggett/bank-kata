(ns bank.parser)
(require '[clojure.string :as string])

  (def nums {1 ["   "
            "  |"
            "  |"]
        2  [" _ "
            " _|"
            "|_ "]
        3  [" _ "
            " _|"
            " _|"]
        4  ["   "
            "|_|"
            "  |"]
        5  [" _ "
            "|_ "
            " _|"]
        6  [" _ "
            "|_ "
            "|_|"]
        7  [" _ "
            "  |"
            "  |"]
        8  [" _ "
            "|_|"
            "|_|"]
        9  [" _ "
            "|_|"
            " _|"]
        0  [" _ "
            "| |"
            " _ "]})

(defn trim-text
  [text]
  (-> text
      (string/replace  #"\n" "")
      (string/split-lines)))
  (defn make-nested-vector
    [v]
    (map vector (subvec v  0 9) (subvec v 9 18) (subvec v 18)))

(defn get-file
  [file]
    (let [x (->> (slurp file)
         (trim-text)
       (reduce (fn [col st]
                  (into col (re-seq #".{1,3}" st)))[]))]
       (make-nested-vector x)))

(defn make-pieces
  [col]
  (partition 108 col))

(get-file "test2.txt")

(let [t (slurp "test2.txt")]
  (->> (string/replace t #"\n" "")
       (partition 108)))

(map (fn [x]
     ((clojure.set/map-invert nums) x)) (get-file "test2.txt"))
