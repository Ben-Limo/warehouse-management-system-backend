import org.springframework.cloud.contract.spec.Contract;

Contract.make {
    description("should return a category")
    request {
        method GET()
        url("/api/categories/1")
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: 1,
                name: "mainframe",
                description: "lorem ipsum test",
                createAt: "2022-01-02 10:16:33.734",
                updatedAt: "2022-01-02 10:16:33.734"
        )
    }
}

