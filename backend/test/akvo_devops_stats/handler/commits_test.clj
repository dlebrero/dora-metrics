(ns akvo-devops-stats.handler.commits-test
  (:require [clojure.test :refer :all]
            [akvo-devops-stats.commits :as commits]))

(deftest calculate-lead-time
  (let [release-date #inst"2020-08-05"]
    (is (= [{:repository "akvo-flow",
             :authored-date #inst"2020-08-06"
             :release-date release-date}]
          (commits/deploy-time
            {:repository "akvo-flow",
             :sha "77cb97915574009db2c9be27a708e321f443ca67"
             :finish-date release-date}
            [{:repository "akvo-flow"
              :sha "77cb97915574009db2c9be27a708e321f443ca67"
              :authored-date #inst"2020-08-06"}]))))

  (testing "Merge Squash"
    (testing "Commit gets date of first commit in PR."
      (let [release-date #inst"2020-08-05"
            pr-date #inst"2020-08-11"]
        (is (= [{:repository "akvo-flow",
                 :authored-date pr-date
                 :release-date release-date}]
              (commits/deploy-time
                {:repository "akvo-flow",
                 :sha "77cb97915574009db2c9be27a708e321f443ca67",
                 :finish-date release-date}
                [{:repository "akvo-flow",
                  :sha "77cb97915574009db2c9be27a708e321f443ca67",
                  :authored-date #inst"2020-08-06"
                  :first-pr-sha "c0e90d34e1fc218cda7a320bf411f4a833f5cd95",
                  :first-pr-authored-date pr-date
                  :index 300}])))))))
