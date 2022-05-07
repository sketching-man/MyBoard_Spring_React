export function BoardArticle({ article }) {
    return (
        <div>
            <tr>
                <td>{article.id}</td>
                <td>{article.title}</td>
                <td>{article.userId}</td>
            </tr>
        </div>
    )
}
