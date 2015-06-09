(ns cijp.seqs)

(def v [1 2 3 4])

(def v1 (conj v 5))

(= v v1)

(identical? v v1)

(def v2 (butlast v1))

(= v v2)

;; Find the example

(identical? v v2)

(def l (list 2 3 4))

(def l1 (conj l 1))

(def l2 (rest l1))

(= l l2)

(identical? l l2)

;; Sets and Maps

(def m {:a 1 :b 2 :c 3})

(conj m [:d 4])

(def s #{1 2 3 4 5})

(conj s 2)

;; Equality

(println s)

(def s2 (set (range 1 6)))

(= s s2)

(= [1 2] '( 1 2 ))

(:a {:a 1})

({["foo" "bar"] 1} ["foo" "bar"])

([:a :b :c] 1)

(#{1 2 3} 5)

(filter #{1 2} [1 2 3 4 5])
