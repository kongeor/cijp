(ns cijp.lazy
  (:require [cijp.funcdata :as fd]))

(set! *print-length* 20)

;; Fast!

(take 5 (range 1000000000000))

;; Slow!

(take 5 (drop 1000000000000 (range 1000000000000000000000)))

;; Not the correct way to time it

(time (take 5 (drop 10000000 (range 20000000))))

;; Fixed!

(time (doall (take 5 (drop 10000000 (range 20000000)))))

;; A similar example

(defn printable-odd? [x]
  (println x)
  (odd? x))

(filter printable-odd? (range 20))

(take 5 (filter printable-odd? (range 10000)))

;; Hm ....

(def x (take 5 (filter printable-odd? (range 10000))))

(print x)

;; Infinite sequences

(iterate inc 1)

(iterate (fn [x] (* 2 x)) 1)

(iterate #(* 2 %) 1)


;; List comprehensions

(for [x (range 10)]
  (* x x))

(clojure.pprint/pprint
  (for [x (range 10)
        y (range 10)]
    [x y]))

(for [x (range 5)
      y (range 5)
      :when (not= x y)]
  [x y])

(for [x (range 10) :when (even? x)
      y (range 10) :when (odd? y)]
  [x y])

(for [x (range) :while (< x 5)
      y (range) :while (<= y x)]
  [x y])


;; Cool functions

(zipmap [:first :last] ["Jeffry" "Lebowksi"]) ;; TODO move this elsewhere

(cycle [1 2 3])

(def names (map :name fd/players))

(interleave
  names
  (iterate inc 1)
  (cycle [:red :green]))

;; Partitioning

(partition 3 (range 10))

;; idiomatic

(apply map vector (partition 3 (range 10)))

(map vector [1 2] [3 4] [:a :b])

;; Well, I hope it does not look something like this:

(def asc-let (range 97 123))

(defn rand-char []
  (-> asc-let rand-nth char))

(clojure.pprint/pprint
  (apply
    str
    (take
      3000
      (repeatedly rand-char))))
