(ns cijp.lazy
  (:require [cijp.funcdata :as fd]))

(set! *print-length* 20)

(take 5 (drop 1000000000000 (range 1000000000000000000000)))

(def N (* 2 1000 1000))

(def M (- N 1000))

(time (take 5 (range N)))

;; Hm ...

(time (take 5 (drop M (range N))))

(time (doall (take 5 (drop M (range N)))))


;; 

(defn slow-odd? [x]
  (Thread/sleep 50)
  (odd? x))

(filter slow-odd? (range 20))

(take 5 (filter slow-odd? (range 10000)))

(time (doall (take 17 (filter slow-odd? (range)))))

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

(partition 3 (range 10))

(first (first {:a 1 :b 2}))

;; idiomatic

(apply map vector (partition 3 (range 10)))

(map vector [1 2] [3 4])


;; Putting it all together

(clojure.pprint/pprint
  (map
    #(zipmap [:id :name :will-learn] %)
    (partition
      3
      (interleave
        (iterate inc 1)
        (map :name fd/players)
        (repeat "clojure")))))

(->> fd/players
    (map #(select-keys % [:name]))
    (map #(merge % {:will-lear "clojure"})))

(merge-with)

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


(defn hello [x]
  (str "hello " x))

(def +hello (partial hello "takis"))

(def ++hello (comp count clojure.string/reverse +hello))

(repeatedly ++hello)

(def +pending (partial + 5))

(+pending 3)


