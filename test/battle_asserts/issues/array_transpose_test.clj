(ns battle-asserts.issues.array-transpose-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :as ct]
            [test-helper :as h]
            [battle-asserts.issues.array-transpose :as issue]))

(ct/defspec spec-solution
  20
  (prop/for-all [v (issue/arguments-generator)]
                (= (count (apply issue/solution v))
                   (count (ffirst v)))))

(ct/defspec spec-signature
  20
  (prop/for-all [v (issue/arguments-generator)]
                (true? (h/generate-signatures issue/signature v))))

(deftest test-solution
  (h/generate-tests issue/test-data issue/solution))

(deftest test-data-tests
  (h/generate-data-tests issue/test-data issue/signature))