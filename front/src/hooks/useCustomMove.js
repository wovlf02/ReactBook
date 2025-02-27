import {useCallback, useState} from "react";
import {createSearchParams, useNavigate, useSearchParams} from "react-router-dom";

const useCustomMove = () => {

    const navigate = useNavigate();
    const [refresh, setRefresh] = useState(false);
    const [queryParams] = useSearchParams();
    const page = queryParams.get("page") ? parseInt(queryParams.get("page")) : 1;
    const size = queryParams.get("size") ? parseInt(queryParams.get("size")) : 10;
    const queryDefault = createSearchParams({page, size}).toString()

    const moveToList = (pageParam) => {
        let queryStr = ""
        if(pageParam) {
            const page = queryParams.get("page") ? parseInt(queryParams.get("page")) : 1
            const size = queryParams.get("size") ? parseInt(queryParams.get("size")) : 10

            queryStr = createSearchParams({page: page, size: size}).toString()
        } else {
            queryStr = queryDefault
        }
    }

    const moveToModify = useCallback((num) => {
        console.log(queryDefault)
        navigate({pathname: `../modify/${num}`, search: queryDefault})
    }, [page, size, refresh])

    const moveToRead = (num) => {
        console.log(queryDefault)
        navigate({
            pathname: `../read/${num}`,
            search: queryDefault
        })
    }

    return {moveToList, moveToModify, moveToRead, page, size, refresh}
}

export default useCustomMove;