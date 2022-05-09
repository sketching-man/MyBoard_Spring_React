import { useEffect } from 'react/cjs/react.production.min';
import './components.module.css'

export function Article({ article }) {

    // useEffect(() => {
    
    // }, [null]);

    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <td>{article.title}</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>{article.body}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}
