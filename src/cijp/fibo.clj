(ns cijp.fibo)

;;

(set! *print-length* 10)

(defn fact [n]
  (condp = n
    0 1
    (* n (fact (dec n)))))

(fact 10)

(fact 30)

(fact 50)

(fact 100)

(fact 1000)

(fact 3000)

(fact 10000)



#_(defn fact [n]
  (condp = n
    0 1
    (* n (recur (dec n)))))

(defn fact [n]
  (letfn [(f [n acc]
              (if (= n 0)
                acc
                (recur (dec n) (* n acc))))]
    (f n 1)))

(fact 5)

(defn fact [n]
  (reduce * (range 1N (inc n))))

(fact 10000)

(defn fibo [n]
  (condp = n
    0 1
    1 1
    (+ (fibo (dec n))
       (fibo (- n 2)))))

(fibo 5)

(time (fibo 32))

(def memo-fibo (memoize fibo))

(time (memo-fibo 36))

;; (fibo 100)


;; Clojure style fibo

(defn fb [[a b]] [b (+ a b)])

(fb [2 3])

(defn fb-iter []  (iterate fb [1 1]))

(fb-iter)

(map first (fb-iter))

(defn fibo [n]
  (map first (take n (fb-iter))))

(defn fibo [n]
  (->> (iterate
         (fn [[a b]] [b (+ a b)])
         [1 1])
       (take n)
       (map first)))

(fibo 10)
