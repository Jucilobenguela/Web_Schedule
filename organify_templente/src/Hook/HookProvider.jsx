

import React, { useContext, useCallback, createContext, useState } from "react";

// Cria o contexto
const context = createContext();

// Hook para consumir o contexto
export function useContextValue() {
    return useContext(context);
}

// Provider do contexto
export default function HookProvider({ children }) {
    const [showCreate, setShowCreate] = useState(false);
    const [showLogin, setShowLogin] = useState(false);

    // Função para atualizar o contexto
    const showFormCreate = useCallback((value) => {
        setShowCreate(value);
        setShowLogin(!value);
    }, []);

    const showFormLogin = useCallback((value) => {
        setShowCreate(!value);
        setShowLogin(value);
    }, []);

    return (
        <context.Provider value={{ showCreate,showLogin,showFormCreate, showFormLogin }}>
            {children}
        </context.Provider>
    );
}