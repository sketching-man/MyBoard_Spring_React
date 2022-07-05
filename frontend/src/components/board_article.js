export function BoardArticle({ article }) {
    return (
        <div>
            <tr>
                <td>
                    <a href={'/${article.id}'}>{article.id}</a>
                </td>
                <td>{article.title}</td>
                <td>{article.userId}</td>
            </tr>
        </div>
    );
}
