-- :name insert-commit! :!
INSERT INTO commits (repository, sha, authored_date, message_headline, first_pr_sha, first_pr_authored_date, merge_commit_sha)
VALUES (:repository, :sha, :authored-date, :message-headline, :first-pr-sha, :first-pr-authored-date, :merge-commit-sha)

-- :name get-cleaned-up-commits-for-repo :? :*
SELECT * FROM commits WHERE repository=:repository AND (merge_commit_sha IS NULL OR sha=merge_commit_sha) ORDER BY index DESC

-- :name last-commit-for-repo :? :1
SELECT * FROM commits where repository=:repository order by index DESC LIMIT 1