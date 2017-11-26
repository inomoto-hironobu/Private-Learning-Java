(print "HelloWorld")
(print (+ 1 2))
(def x 1)
(let [y 2]
  (if-not (= y 1)
    print "test")
  )
(defn test1 [x]
  (if (= x 1)
    (+ x 22)
    (+ x 1)
    ))
(print (test1 1))