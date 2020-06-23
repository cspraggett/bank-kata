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
      ))
  (defn make-nested-vector
    [v]
    (let [x (vec v)]
    (map seq (subvec x  0 9) (subvec x 9 18) (subvec x 18))))
(defn get-file
  [file]
 (let [x (string/replace (slurp "test2.txt") #"\n" "")]   
(->>   (re-seq #".{1,108}" x)
     (map (fn [q]
            (partition 3 q)))
;;(map (fn [x]
  ;;   ((clojure.set/map-invert nums) x)))
    (make-nested-vector)
   (map println) )))  
(reduce (fn [col st]
                  (into col (re-seq #".{1,3}" st))) char-array  ))
       ))
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
